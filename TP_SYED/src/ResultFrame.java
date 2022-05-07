import javax.swing.*;

public class ResultFrame  {
    ResultFrame(Fichier fichier){
    JFrame frame=new JFrame();
    JButton button=new JButton("OK");
    button.addActionListener(e ->{
        frame.dispose();
    });
    JLabel label1=new JLabel("File name: "+fichier.name+fichier.extension);
    JLabel label2=new JLabel();
    JLabel label3=new JLabel("File content: "+fichier.content);
    JLabel label4=new JLabel("File extension: "+fichier.extension);
    label2.setText("<html><body><p>File path: "+fichier.path+"</p></body></html>");
    label1.setBounds(50,50, 300,30);
    label2.setBounds(50,100, 300,30);
    label3.setBounds(50,150, 300,30);
    label4.setBounds(50,200, 300,30);
    button.setBounds(130,320,100, 40);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(button);
    frame.setSize(400,500);
    frame.setLayout(null);
    frame.setVisible(true);
    }

}
