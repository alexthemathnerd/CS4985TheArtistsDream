FXML files and Images should go here
To get this file pretend that you are in the smae folder as the code because at the packageing stage thes folders will merge.
https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html


If you have CodeBehind in src/main/java/edu.westga.devops.theartistsdreamclient.view.CODEBEHIND and you want to get the fxml in the same folder you would
still do getClass().getResources('FXMLNAME.fxml") but you would put the fxml in
	
	src/main/RESOURCES/edu.westga.devops.theartistsdreamclient.view.FXMLNAME.fxml
