
import java.util.Comparator;

public class ComparebyPerimeter implements Comparator<Drawable> {
	

	@Override
	public int compare(Drawable first, Drawable secound) {
		if(first.getPerimeter() > secound.getPerimeter()) {return 1;}
		if(first.getPerimeter() < secound.getPerimeter()) {return -1;}

		return 0;
	}

}
