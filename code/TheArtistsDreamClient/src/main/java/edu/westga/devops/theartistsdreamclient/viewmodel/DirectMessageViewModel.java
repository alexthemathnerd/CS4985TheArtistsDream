public class DirectMessageViewModel {

    private Messager messager;

    public DirectMessageViewModel() {

    }
    
    public void sendMessage(String message, User sender, User reciever) {
        message.sendMessage(message, sender, reciever);
    } 
}
