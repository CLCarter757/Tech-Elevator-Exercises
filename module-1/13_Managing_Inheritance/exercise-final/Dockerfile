# Mount the utilities image which serves as a shared folder
FROM tepublic/te-curriculum-utilities:1.0 AS utilities

# Install LTS version of Java
FROM maven:3.6-openjdk-11

# Set as current directory for RUN, ADD, COPY commands
WORKDIR /app

# Add entire student fork (overwrites previously added files)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER /app

# Overwrite files in student fork with upstream files
COPY src/test/java/com/techelevator /app/src/test/java/com/techelevator
COPY pom.xml ./

# Copy the common scripts from the utilities image
COPY --from=utilities test.java.11.0.sh  ./test.sh
COPY --from=utilities grade.sh ./
