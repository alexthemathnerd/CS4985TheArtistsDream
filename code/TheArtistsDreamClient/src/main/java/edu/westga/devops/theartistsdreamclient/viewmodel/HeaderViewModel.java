package edu.westga.devops.theartistsdreamclient.viewmodel;


public class HeaderViewModel {
    private ObservableList<User> users;
    private NetworkUserManager userManager;
    

    public HeaderViewModel() {
        this.users = new ObservableList<User>();
        this.userManager = new NetworkUserManager();
    }

    public ObservableList<User> searchForUsers(String username) {
        ObserverableList<User> searchedUsers = FXCollections.observableList(this.userManager.searchForUsers(username));
        return searchedUsers;
    }
}


