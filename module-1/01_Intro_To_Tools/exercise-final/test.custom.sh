#!/bin/bash
echo test.custom.sh

# ############################################################################
# Part 1: Look for the output file and grab the number passed and total tests
outputPart1="output-part-1.txt"
part1TotalTests=22

total_number_of_tests=0
total_number_passed=0

if test -f "$outputPart1"; then
    # Grep the totals
    number_of_tests=$(grep -P -o "Total tests: *\K\d+" $outputPart1|head -1)
    number_passed=$(grep -P -o "Tests passed: *\K\d+" $outputPart1|head -1)
else
    echo "Part 1 output file was not found!"
    echo "Please be sure you run 'sh verify-part-1.sh' on your development computer,"
    echo "and then push '$outputPart1' to your repo before submitting to Learn."
    echo
    number_of_tests=$((part1TotalTests))
    number_passed=0
fi

total_number_of_tests=$(( total_number_of_tests+number_of_tests ))
total_number_passed=$(( total_number_passed+number_passed ))
echo Part 1: $number_passed/$number_of_tests passed.

# ############################################################################
# Part 2: Run the verification script

bash verify-part-2.sh > output.txt

# Find the messages in the output
number_of_tests=$(grep -P -o "Total tests: *\K\d+" output.txt|head -1)
number_passed=$(grep -P -o "Tests passed: *\K\d+" output.txt|head -1)

# The tests didn't run and something else is wrong
if [ -z "$number_passed" ] && [ -z "$number_of_tests" ]
then
    sh grade.sh error 'There was an error that prevented the tests from executing.'
    echo 'There was an error that prevented the tests from executing.'
    cat output.txt
    exit 1
elif [ -z "$number_passed" ]
then
    # If not found, use 0
    number_passed=0
fi

total_number_of_tests=$(( total_number_of_tests+number_of_tests ))
total_number_passed=$(( total_number_passed+number_passed ))
echo Part 2: $number_passed/$number_of_tests passed.

# Call the script which writes a grading file and reports the result to the user.

sh grade.sh $total_number_passed $total_number_of_tests

cat $outputPart1
cat output.txt
