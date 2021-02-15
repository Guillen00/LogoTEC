

import java.awt.*;
import java.beans.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 * En esta clase se realizara la caracteristica de agregar una linea con un numero en cada linea del panel contenido
 */
public class NumeroLinea extends JPanel
        implements CaretListener, DocumentListener, PropertyChangeListener {

    /**
     * Se definen variables a utilzar en el codigo interno de la clase
     */
    public final static float LEFT = 0.0f;
    public final static float CENTER = 0.5f;
    public final static float RIGHT = 1.0f;
    private Color color1 = new Color(7,86,100);
    private final static Border OUTER = new MatteBorder(0, 0, 0, 2,Color.BLACK);

    private final static int HEIGHT = Integer.MAX_VALUE - 1000000;

    private JTextComponent component;

    private boolean updateFont;
    private int borderGap;
    private Color currentLineForeground;
    private float digitAlignment;
    private int minimumDisplayDigits;

    
    private int lastDigits;
    private int lastHeight;
    private int lastLine;

    private HashMap<String, FontMetrics> fonts;

    /**
     * Se define una clase constructor la cual contiene como parametro un JTextComponent
     * @param component
     */
    public NumeroLinea(JTextComponent component) {
        this(component, 3);
    }

    /**
     * Se define una clase constructor la cual contiene como parametro un JTextComponent y un entero el cual contiene el funcionamiento total de la clase
     * @param component
     * @param minimumDisplayDigits
     */
    public NumeroLinea(JTextComponent component, int minimumDisplayDigits) {
        this.component = component;

        setFont(component.getFont());

        setBorderGap(5);
        setCurrentLineForeground(color1);
        setDigitAlignment(RIGHT);
        setMinimumDisplayDigits(minimumDisplayDigits);

        component.getDocument().addDocumentListener(this);
        component.addCaretListener(this);
        component.addPropertyChangeListener("font", this);
    }

    /**
     * La funcion getUpdateFont retorna la variable updateFont
     * @return
     */
    public boolean getUpdateFont() {
        return updateFont;
    }

    /**
     * La funcion setUpdateFont cambia el valor de la variable updateFont de la clase por el valor del parametro de entrada
     * @param updateFont
     */
    public void setUpdateFont(boolean updateFont) {
        this.updateFont = updateFont;
    }

    /**
     * La funcion getBorderGap retorna la variable borderGap
     * @return
     */
    public int getBorderGap() {
        return borderGap;
    }

    /**
     * La funcion setBorderGap recibe como parametro un entero el cual cambia el valor de la variable borderGap de la clase y edita el objeto Border
     * @param borderGap
     */
    public void setBorderGap(int borderGap) {
        this.borderGap = borderGap;
        Border inner = new EmptyBorder(0, borderGap, 0, borderGap);
        setBorder(new CompoundBorder(OUTER, inner));
        lastDigits = 0;
        setPreferredWidth();
    }

    /**
     * La funcion getCurrentLineForeground retorna la variable currentLineForeground de tipo Color
     * @return
     */
    public Color getCurrentLineForeground() {
        return currentLineForeground == null ? getForeground() : currentLineForeground;
    }

    /**
     * La funcion setCurrentLineForeground recibe como parametro currentLineForeground que es de tipo Color y cambia el valor de la variable
     * currentLineForeground de la clase por el parametro ingresado
     * @param currentLineForeground
     */
    public void setCurrentLineForeground(Color currentLineForeground) {
        this.currentLineForeground = currentLineForeground;
    }

    /**
     * La funcion getDigitAlignment retorna la variable digitAlignment
     * @return
     */
    public float getDigitAlignment() {
        return digitAlignment;
    }

    /**
     * La funcion setDigitAlignment recibe como parametro digitAlignment el cual cambia su valor a la variable local de la clase llamada
     * digitAlignment
     * @param digitAlignment
     */
    public void setDigitAlignment(float digitAlignment) {
        this.digitAlignment
                = digitAlignment > 1.0f ? 1.0f : digitAlignment < 0.0f ? -1.0f : digitAlignment;
    }

    /**
     * La funcion getMinimumDisplayDigits retorna el valor de la variable minimumDisplayDigits
     * @return
     */
    public int getMinimumDisplayDigits() {
        return minimumDisplayDigits;
    }

    /**
     * La funcion setMinimumDisplayDigits recibe como parametro un entero llamado minimumDisplayDigits el cual sustituye el valor de la variable
     * local llamada minimumDisplayDigits
     * @param minimumDisplayDigits
     */
    public void setMinimumDisplayDigits(int minimumDisplayDigits) {
        this.minimumDisplayDigits = minimumDisplayDigits;
        setPreferredWidth();
    }

    /**
     * La funcion setPreferredWidth le da un reajuste al tamaño de las lineas con corme de agregen o quiten lineas de texto
     */
    private void setPreferredWidth() {
        Element root = component.getDocument().getDefaultRootElement();
        int lines = root.getElementCount();
        int digits = Math.max(String.valueOf(lines).length(), minimumDisplayDigits);

        if (lastDigits != digits) {
            lastDigits = digits;
            FontMetrics fontMetrics = getFontMetrics(getFont());
            int width = fontMetrics.charWidth('0') * digits;
            Insets insets = getInsets();
            int preferredWidth = insets.left + insets.right + width;

            Dimension d = getPreferredSize();
            d.setSize(preferredWidth, HEIGHT);
            setPreferredSize(d);
            setSize(d);
        }
    }

    /**
     * La funcion paintComponent contiene como parametro Graphics el cual dibuja los componentes y actualiza sus posiciones y estados de los objetos
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics fontMetrics = component.getFontMetrics(component.getFont());
        Insets insets = getInsets();
        int availableWidth = getSize().width - insets.left - insets.right;

        Rectangle clip = g.getClipBounds();
        int rowStartOffset = component.viewToModel(new Point(0, clip.y));
        int endOffset = component.viewToModel(new Point(0, clip.y + clip.height));

        while (rowStartOffset <= endOffset) {
            try {
                if (isCurrentLine(rowStartOffset)) {
                    g.setColor(getCurrentLineForeground());
                } else {
                    g.setColor(getForeground());
                }

                String lineNumber = getTextLineNumber(rowStartOffset);
                int stringWidth = fontMetrics.stringWidth(lineNumber);
                int x = getOffsetX(availableWidth, stringWidth) + insets.left;
                int y = getOffsetY(rowStartOffset, fontMetrics);
                g.drawString(lineNumber, x, y);
                rowStartOffset = Utilities.getRowEnd(component, rowStartOffset) + 1;
            } catch (Exception e) {
                break;
            }
        }
    }

    /**
     * La funcion isCurrentLine recibe como parametro un entero el cual valora su estado dentro de root y dependiendo de esta decision
     * retorna un true o false
     * @param rowStartOffset
     * @return
     */
    private boolean isCurrentLine(int rowStartOffset) {
        int caretPosition = component.getCaretPosition();
        Element root = component.getDocument().getDefaultRootElement();

        if (root.getElementIndex(rowStartOffset) == root.getElementIndex(caretPosition)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     *
     * La funcion getTextLineNumber obtiene el valor de la columna ingresado como parametro
     * @param rowStartOffset
     * @return
     */
    protected String getTextLineNumber(int rowStartOffset) {
        Element root = component.getDocument().getDefaultRootElement();
        int index = root.getElementIndex(rowStartOffset);
        Element line = root.getElement(index);

        if (line.getStartOffset() == rowStartOffset) {
            return String.valueOf(index + 1);
        } else {
            return "";
        }
    }

    /*
	 *   Determina el desplazamiento X para alinear correctamente el número de línea cuando se dibuja
     */
    private int getOffsetX(int availableWidth, int stringWidth) {
        return (int) ((availableWidth - stringWidth) * digitAlignment);
    }

    /**
     * La funcion getOffsetY Determina el desplazamiento Y para la fila actual
     * @param rowStartOffset
     * @param fontMetrics
     * @return
     * @throws BadLocationException
     */

    private int getOffsetY(int rowStartOffset, FontMetrics fontMetrics)
            throws BadLocationException {


        Rectangle r = component.modelToView(rowStartOffset);
        int lineHeight = fontMetrics.getHeight();
        int y = r.y + r.height;
        int descent = 0;


        if (r.height == lineHeight)
        {
            descent = fontMetrics.getDescent();
        } else
        {
            if (fonts == null) {
                fonts = new HashMap<String, FontMetrics>();
            }

            Element root = component.getDocument().getDefaultRootElement();
            int index = root.getElementIndex(rowStartOffset);
            Element line = root.getElement(index);

            for (int i = 0; i < line.getElementCount(); i++) {
                Element child = line.getElement(i);
                AttributeSet as = child.getAttributes();
                String fontFamily = (String) as.getAttribute(StyleConstants.FontFamily);
                Integer fontSize = (Integer) as.getAttribute(StyleConstants.FontSize);
                String key = fontFamily + fontSize;

                FontMetrics fm = fonts.get(key);

                if (fm == null) {
                    Font font = new Font(fontFamily, Font.PLAIN, fontSize);
                    fm = component.getFontMetrics(font);
                    fonts.put(key, fm);
                }

                descent = Math.max(descent, fm.getDescent());
            }
        }

        return y - descent;
    }

    /**
     * Implementar la interfaz CaretListener
     * @param e
     */
    @Override
    public void caretUpdate(CaretEvent e) {

        int caretPosition = component.getCaretPosition();
        Element root = component.getDocument().getDefaultRootElement();
        int currentLine = root.getElementIndex(caretPosition);

        if (lastLine != currentLine) {
            repaint();
            lastLine = currentLine;
        }
    }

    /**
     * Implementar la interfaz DocumentListener
     * @param e
     */
    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged();
    }

    /**
     * Esta funcion  Implementar la interfaz DocumentListener
     * @param e
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged();
    }

    /**
     * Esta funcion  Implementar la interfaz DocumentListener
     * @param e
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged();
    }

    /**
     * Un cambio de documento puede afectar el número de líneas de texto mostradas.
     * Por lo tanto, los números de las líneas también cambiarán.
     */
    private void documentChanged() {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    int endPos = component.getDocument().getLength();
                    Rectangle rect = component.modelToView(endPos);

                    if (rect != null && rect.y != lastHeight) {
                        setPreferredWidth();
                        repaint();
                        lastHeight = rect.y;
                    }
                } catch (BadLocationException ex) {
                    /* nothing to do */ }
            }
        });
    }

    /**
     * Cambia las propiedades de la interfaz
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof Font) {
            if (updateFont) {
                Font newFont = (Font) evt.getNewValue();
                setFont(newFont);
                lastDigits = 0;
                setPreferredWidth();
            } else {
                repaint();
            }
        }
    }
}