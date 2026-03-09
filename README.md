# katalon-ifg-ruditest

Automation test project using Katalon Studio for API testing and Kafka event validation.

## Prerequisites

Before running this project, make sure the following tools are installed on your machine:

- Katalon Studio
- Java JDK 8 or higher
- Apache Kafka (installed and running locally)

### Install Kafka (MacOS)

Using Homebrew:

```bash
brew install kafka
brew services start kafka
kafka-topics --bootstrap-server localhost:9092 --list

1.	Clone this repository --> git clone https://github.com/rudiismanto/katalon-ifg-ruditest.git
2.	Open the project using Katalon Studio
3.  Run testsuite Login
