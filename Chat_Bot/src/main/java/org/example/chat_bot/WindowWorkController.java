package org.example.chat_bot;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

import java.io.*;

import static org.example.chat_bot.Bot.*;

public class WindowWorkController {


    public  String UserName;
    public AnchorPane MainWindow;
    public  Message[] ArrayMessages = new Message[200];
    public  int CountMessages = 0;
    public TextField TextFieldMessage;
    public TextArea TextAreaMessages;

    public void onButtonSendMessage(ActionEvent actionEvent) throws IOException {
        AddMessageInArray(ArrayMessages,UserName,TextFieldMessage.getText(),CountMessages);
        AppendMessageInTextArea(ArrayMessages,CountMessages);
        CountMessages++;
        AddMessageInArray(ArrayMessages,"Bot",BotThink(TextFieldMessage.getText(),ArrayMessages[CountMessages - 1].getDate(),CountMessages),CountMessages);
        AppendMessageInTextArea(ArrayMessages,CountMessages);
        CountMessages++;
    }

    public void AddMessageInArray(Message[] Arr,String userName,String message,int Count){
        Arr[Count] = new Message(userName,message);
    }

    public void AppendMessageInTextArea(Message[] Arr,int Count){
        TextAreaMessages.appendText(Arr[Count].toString() + "\n");
    }

    public void onSaveFileClick(ActionEvent actionEvent) {
        SaveDialogInFile(ArrayMessages,CountMessages,UserName);
    }

    public void onOpenFileClick(ActionEvent actionEvent) {
        CountMessages = OpenDialogFromFile(ArrayMessages,CountMessages,UserName);
    }

    public void onAuthorClick(ActionEvent actionEvent) {
    }

    public void onExitClick(ActionEvent actionEvent) {
        MainWindow.getScene().getWindow().hide();
    }

    public void SaveDialogInFile(Message[] Arr,int Count,String userName){
        String FileName = userName + ".txt";
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(FileName)))
        {
            for (int i = 0; i < Count;i ++ ){
                dos.writeUTF(Arr[i].getUserName());
                dos.writeUTF(Arr[i].getMessage());
                dos.writeLong(Arr[i].getDate().getTime());
            }

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public int OpenDialogFromFile(Message[] Arr, int Count, String userName){
        String username,mes;
        long time;
        String FileName = userName + ".txt";
        try(DataInputStream dos = new DataInputStream (new FileInputStream(FileName)))
        {
            //todo: Поработать с CountMessages Чтобы не сбивалось и c разными пользователями тоже)))
            while (dos.available() != 0){
                username = dos.readUTF();
                mes = dos.readUTF();
                time = dos.readLong();
                Arr[Count] = new Message(username,mes,time);
                AppendMessageInTextArea(Arr,Count);
                Count++;
            }
            return Count;

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
            return 0;
        }

    }


    private javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            SaveDialogInFile(ArrayMessages,CountMessages,UserName);
        }
    };

    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler(){
        return closeEventHandler;
    }

    
}
