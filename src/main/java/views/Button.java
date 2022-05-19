/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

/**
 *
 * @author Quandeptrai
 */
public class Button extends JButton implements MouseListener {

    private boolean hover;
    private Color color;
    private Color colorHover;
    private Color borderColor;
    private int borderRadius = 0;

    public Button() {
        setColor(new Color(92, 88, 220));
        colorHover = new Color(23, 59, 103);
        borderRadius = 8;
        this.setForeground(Color.WHITE);
        setContentAreaFilled(false);
        this.setFont(new Font("Roboto", Font.BOLD, 12) {
        });
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(1f, 0f, 0f, 0), 0),
                BorderFactory.createLineBorder(new Color(1f, 0f, 0f, 0), 8)));
        this.addMouseListener(this);
        this.setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2.setColor(getBackground());

        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, borderRadius, borderRadius);
        super.paintComponent(grphcs);
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (hover) {
            setBackground(colorHover);
        } else {
            setBackground(color);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(colorHover);
        hover = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(color);
        hover = false;
    }

}
