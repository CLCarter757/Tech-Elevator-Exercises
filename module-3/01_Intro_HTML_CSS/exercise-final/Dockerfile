# Mount the utilities image which serves as a shared folder
FROM tepublic/te-curriculum-utilities:1.0 AS utilities

# Install current curriculum version of te-cypress
FROM tepublic/te-cypress:8.2.0

# Set as current directory for RUN, ADD, COPY commands
WORKDIR /app

# Copy all of the exercise files
COPY . ./

# Add entire student fork (to get the htm and css files for the exercise)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER ./

# Overwrite files in student fork with upstream files
COPY cypress ./cypress/

# Copy the common scripts from the utilities image
COPY --from=utilities test.cypress.8.2.sh ./test.sh
COPY --from=utilities grade.sh ./
