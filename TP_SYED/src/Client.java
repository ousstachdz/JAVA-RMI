import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends JFrame {
    private JTree tree;
    Repertoire repertoire = new Repertoire();
    public Client() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");

        DefaultMutableTreeNode f1 = new DefaultMutableTreeNode("F1");
        DefaultMutableTreeNode f2 = new DefaultMutableTreeNode("F2");
        DefaultMutableTreeNode f3 = new DefaultMutableTreeNode("F3");
        DefaultMutableTreeNode f4 = new DefaultMutableTreeNode("F4");

        root.add(a);
        root.add(b);
        a.add(f1);
        a.add(f2);
        b.add(f3);
        b.add(f4);

        //create the tree by passing in the root node
        tree = new JTree(root);
        add(tree);
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                doMouseClicked(me);
            }
        });
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Client");
        this.pack();
        this.setVisible(true);
    }

    void doMouseClicked(MouseEvent me) {
        TreePath selectedFile = tree.getPathForLocation(me.getX(), me.getY());
        if (selectedFile != null) {
            String keyWord = selectedFile.getLastPathComponent().toString();
            if (keyWord.contains("F")) {
                try {

                    ////////////////////////////
                    Socket socket = new Socket( Repertoire.localHost, 6666);
                    DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                    dataOut.writeUTF(keyWord);
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String machine = (String) dis.readUTF();
                    dataOut.flush();
                    socket.close();
                    System.out.println(machine);
                    if (machine.contains("Machine")){
                    Fichier file = repertoire.getFile(machine,keyWord);
                    ResultFrame resultFrame = new ResultFrame(file);
                    System.out.println(file.path);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }
    void getMachineName(){
    //to implemnt
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }
}