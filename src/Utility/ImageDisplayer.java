package Utility;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageDisplayer {
    String _ImageUrl;
    String _ImagePath;

    public static void main(String avg[]) throws IOException {

    }

    public ImageDisplayer(String imageUrl){
        _ImageUrl = imageUrl;
    }

    public void setImageUrl(String url){
        _ImageUrl = url;
    }
    public void setImagePath(String path){
        _ImagePath = path;
    }

    /**
     * Displays an image from set file path into JFrame
     */
    public void displayImageFromFile(){
        try{
            BufferedImage img=ImageIO.read(new File(_ImagePath));
            ImageIcon icon=new ImageIcon(img);
            JFrame frame=new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(200,300);
            JLabel lbl=new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Displays an image from set url into JFrame
     */
    public void displayImageFromUrl(){
        try{

            URL url = new URL(_ImageUrl);
            BufferedImage image = ImageIO.read(url);
            JLabel label = new JLabel(new ImageIcon(image));
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(label);
            frame.pack();
            frame.setSize(223,311);
            frame.setVisible(true);


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

