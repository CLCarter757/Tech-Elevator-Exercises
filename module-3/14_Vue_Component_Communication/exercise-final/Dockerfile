# Mount the utilities image which serves as a shared folder
FROM tepublic/te-curriculum-utilities:1.0 AS utilities

# Install current curriculum version of te-vue
FROM tepublic/te-vue:2.4.0

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
ADD $SUBMISSION_SUBFOLDER /app

# Overwrite files in student fork with upstream files
COPY package*.json ./
COPY tests ./tests

# Copy the common scripts from the utilities image
COPY --from=utilities test.vue.cypress.sh ./test.sh
COPY --from=utilities grade.sh ./
