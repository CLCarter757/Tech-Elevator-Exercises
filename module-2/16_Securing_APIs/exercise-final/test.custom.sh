#!/bin/bash
echo test.custom.sh

# function run_maven_test folder
#       $1 = folder. function will move to that folder and run tests. It will change back to parent before returning
run_maven_test () {
    echo Running $1 tests...
    # Switch directories
    cd $1

    # Run tests
    outfile=../$1_output.txt
    mvn test -e -B > $outfile

    # Turn on recursive globbing in Bash
    shopt -s globstar
    number_of_tests=$(grep -o -i -w @Test src/test/**/*.java | wc -l)
    number_of_run_tests=$(tac $outfile | grep -P -o "(?<=Tests run: )(\d+)" | head -1)

    # The tests didn't run and something else is wrong
    if [ -z "$number_of_run_tests" ]
    then
        sh grade.sh error 'There was an error that prevented the tests from executing in $1.'
        sed -n '/^\[ERROR\].*$/,$p' $outfile
        exit 1
    fi

    number_of_failures=$(tac $outfile | grep -P -o "(?<=Failures: )(\d+)" | head -1)
    number_of_errors=$(tac $outfile | grep -P -o "(?<=Errors: )(\d+)" | head -1)
    number_passed=$((number_of_run_tests-(number_of_failures+number_of_errors)))

    echo $1: Tests: $number_of_tests, Passed: $number_passed

    # Accumulate the totals
    (( total_passed+=number_passed))
    (( total_tests+=number_of_tests ))

    # Switch back to parent directory
    cd ..
}

# Initialize the totals
total_tests=0
total_passed=0

# Run the client tests
run_maven_test "client"

# Run the server tests
run_maven_test "server"

# Call the script which writes a grading file and reports the result to the user.
sh grade.sh $total_passed $total_tests

# Print the output from both test runs
echo ---------------------------------------------------------------------------------------
echo Client output:
echo ---------------------------------------------------------------------------------------
sed -n '/T E S T S/,$p' client_output.txt
echo ---------------------------------------------------------------------------------------
echo Server output:
echo ---------------------------------------------------------------------------------------
sed -n '/T E S T S/,$p' server_output.txt
