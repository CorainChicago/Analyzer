# Document Analyzer

### Description

This service takes in a text document and configuration for analysis, use stop words and find root words.  It returns out a response with the configuration give, original text, count of each word, and top 25 words in the list. The user can submit the test in the request or put the text file in the `/resources/text/` folder and request the analysis of the file using the file name.    

There are endpoints to return the previous results and to get previous response by the name of the file.  

### Getting Started
1. Clone the repository
1. Go into the root directory in the command line
1. Run`./build.sh`
1. Run `docker-compose up -d`

This will build the image for the service and run two docker containers, one for the service and the other for the mongo database.  

### API Usage

#### Text Analysis 
To get an analysis of a text, there are two ways to submit the document and request.

##### File Folder Method 
1. Add the text time to the `/resources/text/` folder with a unique name.  
2. Submit a `GET` request to `localhost:8080/`, in the headers have 'Content-Type: application/json', and  have the configuration of the analysis in the body like this:
```json

{ 
	"name": <NAME OF FILE WITH EXTENSION>,
	"useStopWords": true,
	"useRootWords": true
}
``` 

Here is an example curl request:

```curl
curl -X POST \
  http://localhost:8080/ \
  -H 'Content-Type: application/json' \
  -d '

{ 
	"name": "exercisedocument.txt",
	"stem" : true,
	"useStopWords": false,
	"useRootWords": true
}
'
```

#### Other endpoints

1. Previous -  `GET` to `http://localhost:8080/previous` with parameters of `count` with an integer will return the most recent number of responses.
    ```curl
   curl -X GET \
     'http://localhost:8080/previous?count=4' \
     -H 'Content-Type: application/json' \
    ````
   
1. Previous -  `GET` to `http://localhost:8080/previous` with parameters of `count` with an integer will return the most recent number of responses.
    ```curl
   curl -X GET \
     'http://localhost:8080/previous?count=4' \
     -H 'Content-Type: application/json' \
    ````