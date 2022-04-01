#!/bin/bash
echo test.custom.sh

run_cypress_test () {
    npm run test-headless > ../output-$1.txt
    number_of_tests=$(grep -P -o "(?<=Tests:        )(\d+)" ../output-$1.txt | tr -d '[:space:]')
    number_of_passing=$(grep -P -o "(?<=Passing:      )(\d+)" ../output-$1.txt | tr -d '[:space:]')

    # The tests didn't run and something else is wrong
    if [ -z $number_of_tests ]
    then
        sh grade.sh error 'There was an error that prevented the tests from executing.'
        cat ../output-$1.txt
        exit 1
    fi

    (( total_number_of_tests+=number_of_tests ))
    (( total_number_of_passing+=number_of_passing ))
}

cd shopping-list
run_cypress_test 'shop';

cd ../calculator
run_cypress_test 'calc' ;

# Call the script which writes a grading file and reports the result to the user.
cd ..
sh grade.sh $total_number_of_passing $total_number_of_tests

# Print the output from both test runs
echo ---------------------------------------------------------------------------------------
echo Shopping List output:
echo ---------------------------------------------------------------------------------------
sed -n '/Running:/,/==============================================/p' output-shop.txt

echo ---------------------------------------------------------------------------------------
echo Calculator output:
echo ---------------------------------------------------------------------------------------
sed -n '/Running:/,/==============================================/p' output-calc.txt
