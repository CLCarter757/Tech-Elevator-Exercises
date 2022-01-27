# Mount the utilities image which serves as a shared folder
FROM tepublic/te-curriculum-utilities:1.0 AS utilities

# Install a simple base image
# FROM node:14.15.5
# The node image is built upon buildpack-deps, so I think I can use just that base image.
FROM buildpack-deps:21.04

WORKDIR /app

# Add entire student fork (overwrites previously added files)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER /app

# Overwrite files in student fork with upstream files
COPY verify-part-2.sh ./verify-part-2.sh

# Copy the common scripts from the utilities image
COPY --from=utilities grade.sh ./
COPY test.custom.sh  ./test.sh
