package dat.startcode.model.services;

public class SVG {

    StringBuilder svgBuilder = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private String width;
    private String height;

    private final String headerTemplate = "<svg height=\"%s\" " +
            "width=\"%s\" " +
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String dashedLineTemplate ="<line x1=\" %d \"y1=\" %d \" x2=\"%d\" y2=\" %d \" style=\"stroke: black; stroke-dasharray:10,5\" />\n";
//    "<path stroke-dasharray=\\\"5,5\\\" d=\\\"M%d %d l%d %d\\\" />\"";
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
            "</defs>" +
            "<line x1=\"%d\"  y1=\"%d\" x2=\"%d\"   y2=\"%d\" \n" +
            "\tstyle=\"stroke: #006600;\n" +
            "\tmarker-start: url(#beginArrow);\n" +
            "\tmarker-end: url(#endArrow);\"/>" +
            "<text style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(%d)\">%s cm</text>";



    private final String messurementTemplate = "";


    public SVG(int x, int y, String viewBox, String width, String height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svgBuilder.append(String.format(headerTemplate, height, width, viewBox, x, y ));
        //svgBuilder.append(arrowTemplate);
    }
    public void addRect(int x, int y, int height, int width) {
        svgBuilder.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2 ) {
       svgBuilder.append(String.format(lineTemplate,x1,y1,x2,y2));
    }

    public void addArrow (int x1, int y1, int x2, int y2,int x3, int y3,int rotate,String messurment){
        svgBuilder.append(String.format(arrowTemplate,x1,y1,x2,y2,x3,y3,rotate,messurment));
    }

    public void addDashedLine (int x1,int y1 ,int x2,int y2){
        svgBuilder.append(String.format(dashedLineTemplate,x1,y1,x2,y2));
    }


    public void addSvg(SVG innerSVG) {
        svgBuilder.append(innerSVG.toString());
    }

    @Override
    public String toString() {
        return svgBuilder.toString() + "</svg>" ;
    }

}
