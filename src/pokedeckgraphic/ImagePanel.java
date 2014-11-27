package pokedeckgraphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/5654926 */
public class ImagePanel extends JPanel {

    private final BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
        //this.setPreferredSize(new Dimension(320, 240));
       // this.setBackground(new Color(random.nextInt()));
        this.add(new JLabel(new ImageIcon(image)));
    }

}
