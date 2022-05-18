package dat.startcode.model.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;stroke-width:2\" />";
    private final String arrowTemplate = "<defs>\n" +
            " <marker \n" +
            " \tid=\"beginArrow\" \n" +
            " \tmarkerWidth=\"12\" \n" +
            " \tmarkerHeight=\"12\" \n" +
            " \trefX=\"0\" \n" +
            " \trefY=\"6\" \n" +
            " \torient=\"auto\">\n" +
            "   <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            " </marker>\n" +
            " <marker \n" +
            " \tid=\"endArrow\" \n" +
            " \tmarkerWidth=\"12\" \n" +
            " \tmarkerHeight=\"12\" \n" +
            " \trefX=\"12\" \n" +
            " \trefY=\"6\" \n" +
            " \torient=\"auto\">\n" +
            "   <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            " </marker>\n" +
            "</defs>";
    private final String messurementTemplate = "";


    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y ));
    }
    public void addRect(int x, int y, int height, int width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2 ) {
//        svg.append(String.format(x1,y1,x2,y2));
    }

    public void addArrow (int x, int y, double height, double width){
        svg.append(String.format(arrowTemplate,x,y,height,width));
    }


    public void addSvg(SVG innerSVG) {
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }

}
