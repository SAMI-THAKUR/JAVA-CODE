package SWING;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.*;

public class chap2_GUI {
    public static void main(String[] args) {
        ImageIcon im2 = new ImageIcon("C:\\Users\\SAMI\\IdeaProjects\\untitled2\\src\\SWING\\sp.png");  // -->  spider man img
        Border bo = BorderFactory.createLineBorder(Color.green,3);




        //  ###   J label is GUI display area to add text , image or both   ###  //
        JLabel jl = new JLabel();
        jl.setText("BRO , DO YOU EVEN CODE !!");  //  --> set text of label
        jl.setIcon(im2);  // adds image
        jl.setHorizontalTextPosition(JLabel.CENTER);  // sets image wrt ot image center, left or right
        jl.setVerticalTextPosition(JLabel.TOP);  // CENTRE , TOP and BOTTOM
        jl.setHorizontalAlignment(JLabel.RIGHT);
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setForeground(Color.red);  // set text color
        jl.setIconTextGap(-20);
        jl.setBackground(new Color(193, 73, 233));  // sets label background color
        jl.setOpaque(true);
        jl.setBorder(bo);   //  sets border
        jl.setBounds(50,50,400,400);  // sets dimensions
        //  *************************************  //
        // ###   J PANEL is a GUI container as to hold components   ###  //
        JPanel jp = new JPanel();
        jp.setBackground(new Color(200,95,18));
        jp.setBounds(0,0,500,500);
        jp.add(jl);  //  -->  adding a label to panel

        JPanel jp2 = new JPanel();
        jp2.setBackground(new Color(100,8,68));
        jp2.setBounds(500,0,500,500);
        //  *************************************  //
        //  ###  J BUTTON  
         //  ************************************   //
        ///   ###   J FRAME IS A GUI WINDOW TO ADD TERMINAL   ###   ///
        JFrame jf = new JFrame();  // --> creates a frame
        jf.setVisible(true);  //javax.swing.ComponentInputMap --> makes frame visible
        jf.setSize(400,400);
        jf.add(jl);  // --> adding text to frame
        jf.setLayout(null);
        jf.setTitle("SAMI THAKUR");
        ImageIcon img = new ImageIcon("C:\\Users\\SAMI\\IdeaProjects\\untitled2\\src\\SWING\\wp7250087.jpg");
        jf.setIconImage(img.getImage());  // --> changes logo of j frame class
        jf.getContentPane().setBackground(Color.yellow);  // --> sets background color
        jf.setResizable(true);
        jf.add(jp);  // --> adding panel to frame
        jf.add(jp2);




    }
}
