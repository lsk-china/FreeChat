package com.lsk.freechat.backend.service;

import lombok.Data;

enum Status{
    Online,
    Chatting,
    Offline,
    Shadow, //user can read but cannot send messages,others cannot discover the user is still online,just like shadow
}

@Data
public class UserData {
    private String userName;
    private String passwd;
    private long id;

    private Status status;
    private long chatPartnerId; //When Status is Chatting, update chatPartnerId data, 
                                //and if the ID of the conversation partner is the same, the conversation partner will 
                                //be displayed as typing in the chat interface


}
