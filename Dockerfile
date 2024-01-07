# Use an official .NET Core runtime as a base image
FROM mcr.microsoft.com/dotnet/core/runtime:3.1

# Label the author of the image
LABEL maintainer="chaimaAhmed <chaima.ahmed@polytechnicien.tn>"

# Install dependencies
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
       logrotate \
       wget \
    && rm -rf /var/lib/apt/lists/*

# Create a directory for your application
WORKDIR /app

# Copy the application files into the container
COPY . /app

# Expose the port on which your application will run
EXPOSE 80

# Command to run your application
