#!/bin/bash
### #####################################################################################
### This is an empty test.sh. Dockerfile will copy a common test.sh from the te-utilities 
### image to run the tests.
### This file is required, else Learn Preview and Publish will not work. They check the 
### 'upstream' for both 'dockerfile' and 'test.sh' and fail if not there.
### #####################################################################################
### 
### For those units that cannot use a 'standard' test.sh and need to override, replace
### this file with the logic you need, and edit dockerfile, changing:
###     COPY --from=utilities test.dotnet.3.1.sh  ./test.sh
### to:
###     COPY test.sh ./
### #####################################################################################

echo ERROR - There was an issue overriding test.sh - please contact support.