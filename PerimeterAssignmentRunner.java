import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
         int c=0;
        for (Point cp:s.getPoints())
        {
            c=c+1;
        }
        return c; 
        
    }

    public double getAverageLength(Shape s) {
        // Put code here
         double sum=0;int nn;
          Point pp=s.getLastPoint();
         for (Point cp:s.getPoints())
         {
           double dist=pp.distance(cp);
           sum+=dist;
           pp=cp;
        }
        nn=getNumPoints(s);
        double av=sum/nn;
        return av;
         
       
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double lar=0.0;
        Point pp=s.getLastPoint();
        for(Point cp:s.getPoints())
        {
            double dist=cp.distance(pp);
            System.out.println(dist);
            if (dist>=lar)
            {
                lar=dist;}
            pp=cp;
        }
                return lar;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double larx=0.0;double x_val;
        for (Point cp:s.getPoints())
        {
           x_val=cp.getX();
           System.out.println(x_val);
           if(x_val>larx)
           {
            larx=x_val;   
    }}
    return larx;}

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr=new DirectoryResource();
         double larp=0.0;
        for (File f:dr.selectedFiles())
        {
            FileResource fr=new FileResource(f);
            Shape s=new Shape(fr);
            double perimeter=getPerimeter(s);
            System.out.println(perimeter);
            if (larp<perimeter)
            {
                larp=perimeter;
            
    }}
    return larp;}

    public String getFileWithLargestPerimeter() {
        // Put code here
         File temp=null;
        DirectoryResource dr=new DirectoryResource();
        double largest_p=getLargestPerimeterMultipleFiles();
        for (File f:dr.selectedFiles()) // f is name,fr1 is full file
        {
            FileResource fr1=new FileResource(f);
            Shape s1=new Shape(fr1);
            if (getPerimeter(s1)==largest_p)
            {
                temp=f; // temp file stores the file f which has the largest perimeter
                
        
    }}return temp.getName(); //getName() method gives only file name of temp and not its actual contents because f and fr1 can't be used outside for each loop
}

    public void testPerimeter () {
 ;       FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
         int number=getNumPoints(s);
         System.out.println(number);
        double average=getAverageLength(s);
        System.out.println(average); 
        double largest=getLargestSide(s);
        System.out.println("largest side is"+largest);
        double largest_x=getLargestX(s);
        System.out.println("largest x is "+largest_x);
        printFileNames();
       testPerimeterMultipleFiles();
       testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double lp=getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter of all files is"+lp);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name_f=getFileWithLargestPerimeter();
        System.out.println("largest perimeter file name is"+name_f);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
       
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) { // create a variable f of type file which takes one file at a time by its name only (not its contents) from all the files we selected
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
