package bases;

public class Rectangle {
    public float x;
    public float y;
    public float Height;
    public float Width;




    public Rectangle(){
        this(0,0,0,0);
    }
    public Rectangle(float x, float y, float Width, float Height) {
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
    }

    public static void main(String[] arg){
        boolean fact = false;
        Rectangle r1 = new Rectangle(1,2,3,4);
        Rectangle r2 = new Rectangle(2,3,4,5);
        if (r1.x < r2.x && r1.y < r2.y){
            if ((r1.x + r1.Width) > r2.x && (r1.x + r1.Width) < (r2.x + r2.Width)){
               if ((r1.y + r1.Height) > r2.y){
                   fact = true;
               }
            }else if ((r1.x + r1.Width) > (r2.x + r2.Width)){
                if ((r1.y + r1.Height) > r2.y && (r1.y + r1.Height) < (r2.y + r2.Height)){
                    fact = true;
                }
            }
        }
        else if (r1.x > r2.x && r1.y > r2.y){
            if ((r2.x + r2.Width) > r1.x && (r2.x + r2.Width) < (r1.x + r1.Width)){
                if ((r2.y + r2.Height) > r1.y){
                    fact = true;
                }
            }else if ((r2.x + r2.Width) > (r1.x + r1.Width)){
                if ((r2.y + r2.Height) > r1.y && (r2.y + r2.Height) < (r1.y + r1.Height)){
                    fact = true;
                }
            }
        }else if (r1.x < r2.x && r1.y > r2.y){
            if ((r1.x + r1.Width) > r2.x && (r1.x + r1.Width) < (r2.x + r2.Width)){
                if ((r2.y + r2.Height) > r1.y){
                    fact = true;
                }
            }else if ((r1.x + r1.Width) > (r2.x + r2.Width)){
                if ((r2.y + r2.Height) > r1.y && (r2.y + r2.Height) < (r1.y + r1.Height)){
                    fact = true;
                }
            }
        }else if (r1.x > r2.x && r1.y < r2.y){
            if ((r2.x + r2.Width) > r1.x && (r2.x + r2.Width) < (r1.x + r1.Width)){
                if ((r1.y + r1.Height) > r2.y){
                    fact = true;
                }
            }else if ((r2.x + r2.Width) > (r1.x + r1.Width)){
                if ((r1.y + r1.Height) > r2.y && (r1.y + r1.Height) < (r2.y + r2.Height)){
                    fact = true;
                }
            }
        }
        if (fact){
            System.out.println("2 hinh chu nhat giao nhau");
        }
        else System.out.println("2 hinh chu nhat khong giao nhau");
    }
}
