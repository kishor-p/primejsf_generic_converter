package kishorp.primejsf.genconv;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import kishorp.primejsf.genconv.beans.Movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter("kishorp.primejsf.genconv.GenericMovieConverter")
public class MovieConverter implements Serializable,Converter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1331408671220587105L;
	private final Logger LOG = LoggerFactory.getLogger(MovieConverter.class);

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String strValue) {
		
		try{
			List<UIComponent> childComponents = uiComponent.getChildren();
		
			if(null != childComponents){
				for(UIComponent tempchild : childComponents){
					if(tempchild instanceof UISelectItems){
						UISelectItems selectItems = (UISelectItems)tempchild;
						List<Movie> sourceList = (List<Movie>) selectItems.getValue();
						
						for(Movie travMovie : sourceList){
							if(travMovie.getUniqueId().equals(strValue)){
								return travMovie;
							}
						}
					}else{
						LOG.info("The Component does not contain any child of type UISelectItems");
					}
				}
			}else{
				LOG.info("The Component does not contain any child elements");
			}
		}catch(Exception e){
			LOG.error("getAsObject-Error while acquiring the SOURCE_MOVIE_LIST from Component attribute:",e);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object objValue) {

		try{
			Movie retMovie = (Movie)objValue;
			return retMovie.getUniqueId();
		}catch(Exception e){
			LOG.error("getAsString()-Error while getting stirng from Object:",e);
		}
		return null;
	}

}
