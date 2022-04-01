# Mount the utilities image which serves as a shared folder
FROM tepublic/te-curriculum-utilities:1.0 AS utilities

# Install current curriculum version of node
FROM node:14.15.5

# Set as current directory for RUN, ADD, COPY commands
WORKDIR /app

# Add to PATH
ENV PATH /app/node_modules/.bin:$PATH

# Add package.json from upstream
COPY package*.json ./

# Install dependencies
RUN npm install

# Add entire student fork (overwrites previously added package.json)
ARG SUBMISSION_SUBFOLDER
COPY $SUBMISSION_SUBFOLDER ./

# Overwrite files in student fork with upstream files
COPY package*.json ./
COPY /shopping-list/tests/ ./shopping-list/tests/

# Copy the common scripts from the utilities image
COPY --from=utilities test.javascript.mocha.sh  ./test.sh
COPY --from=utilities grade.sh ./

# Move tests files since this project is set up slightly different from others
RUN mv /app/shopping-list/tests/* /app/
