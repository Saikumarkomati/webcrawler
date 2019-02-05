# webcrawler
SpringBoot applicaiton with RestAPI end points
Java version : 1.8

Import the project to Eclipse IDE
Right clieck on WebCrawlerApplication.java and Run as Java Applicaiton

Sample Test Url:
  Query Param : "crawlurl" holds the url to be crawlled
  http://localhost:8080/crawlweb?crawlurl=http://www.mit.edu/


Rest endpoints with header accept="text/plain" will produce text output
Rest endpoints with header accept="applicaiton/xml" will produce xml output

You may use WebCrawlerTest.java which is a RestClient.
When using rest client set the header appropriately to get XML/JSON/Text response
