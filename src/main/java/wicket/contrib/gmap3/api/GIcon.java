/*
 * $Id$
 * $Revision$
 * $Date$
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.contrib.gmap3.api;

import java.util.Iterator;
import java.util.List;

/**
 * Represents an Google Maps API's
 * http://code.google.com/apis/maps/documentation/reference.html#GIcon
 * 
 * @author Robert Jacolin, Gregory Maes, Vincent Demay, Anyware Technologies
 */
public class GIcon implements GValue, Cloneable {

    private static final long serialVersionUID = 1714038753187423501L;

    private String image;
    private String shadow;
    private GSize iconSize = null;
    private GSize shadowSize = null;
    private GPoint iconAnchor = null;
    private GPoint infoWindowAnchor = null;
    private GPoint infoShadowAnchor = null;

    /**
     * http://code.google.com/intl/de/apis/maps/documentation/reference.html#
     * GIcon.imageMap
     */
    private List<Integer> imageMap = null;

    public GIcon() {
        image = "http://www.google.com/mapfiles/marker.png";
        shadow = "http://www.google.com/mapfiles/shadow50.png";

    }

    public GIcon( final String image ) {
        this.image = image;
        shadow = "http://www.google.com/mapfiles/shadow50.png";
    }

    public GIcon( final String image, final String shadow ) {
        this.image = image;
        this.shadow = shadow;
    }

    public GIcon( final String image, final String shadow, final GSize iconSize, final GSize shadowSize, final GPoint iconAnchor,
            final GPoint infoWindowAnchor, final GPoint infoShadowAnchor ) {
        this.image = image;
        this.shadow = shadow;
        this.iconSize = iconSize;
        this.shadowSize = shadowSize;
        this.iconAnchor = iconAnchor;
        this.infoWindowAnchor = infoWindowAnchor;
        this.infoShadowAnchor = infoShadowAnchor;
    }

    @Override
    public GIcon clone() {
        try {
            return (GIcon) super.clone();
        } catch ( final CloneNotSupportedException e ) {
            throw new Error( e );
        }
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final GIcon other = (GIcon) obj;
        if ( iconAnchor == null ) {
            if ( other.iconAnchor != null ) {
                return false;
            }
        } else if ( !iconAnchor.equals( other.iconAnchor ) ) {
            return false;
        }
        if ( iconSize == null ) {
            if ( other.iconSize != null ) {
                return false;
            }
        } else if ( !iconSize.equals( other.iconSize ) ) {
            return false;
        }
        if ( image == null ) {
            if ( other.image != null ) {
                return false;
            }
        } else if ( !image.equals( other.image ) ) {
            return false;
        }
        if ( imageMap == null ) {
            if ( other.imageMap != null ) {
                return false;
            }
        } else if ( !imageMap.equals( other.imageMap ) ) {
            return false;
        }
        if ( infoShadowAnchor == null ) {
            if ( other.infoShadowAnchor != null ) {
                return false;
            }
        } else if ( !infoShadowAnchor.equals( other.infoShadowAnchor ) ) {
            return false;
        }
        if ( infoWindowAnchor == null ) {
            if ( other.infoWindowAnchor != null ) {
                return false;
            }
        } else if ( !infoWindowAnchor.equals( other.infoWindowAnchor ) ) {
            return false;
        }
        if ( shadow == null ) {
            if ( other.shadow != null ) {
                return false;
            }
        } else if ( !shadow.equals( other.shadow ) ) {
            return false;
        }
        if ( shadowSize == null ) {
            if ( other.shadowSize != null ) {
                return false;
            }
        } else if ( !shadowSize.equals( other.shadowSize ) ) {
            return false;
        }
        return true;
    }

    public GPoint getIconAnchor() {
        return iconAnchor;
    }

    public GSize getIconSize() {
        return iconSize;
    }

    public String getId() {
        return "icon" + String.valueOf( System.identityHashCode( this ) );
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getImageMap() {
        return imageMap;
    }

    public GPoint getInfoShadowAnchor() {
        return infoShadowAnchor;
    }

    public GPoint getInfoWindowAnchor() {
        return infoWindowAnchor;
    }

    public String getJSconstructor() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append( "(function() {\n" );
        buffer.append( "var icon = new GIcon();\n" );
        buffer.append( "icon.image = \"" ).append( image ).append( "\";\n" );
        if ( shadow != null ) {
            buffer.append( "icon.shadow = \"" ).append( shadow ).append( "\";\n" );
        }

        if ( iconSize != null ) {
            buffer.append( "icon.iconSize = " ).append( iconSize.getJSconstructor() ).append( ";\n" );
        }

        if ( shadowSize != null ) {
            buffer.append( "icon.shadowSize = " ).append( shadowSize.getJSconstructor() ).append( ";\n" );
        }
        if ( imageMap != null ) {
            buffer.append( "icon.imageMap  = [" );
            final Iterator<Integer> imit = imageMap.iterator();
            while ( imit.hasNext() ) {
                buffer.append( imit.next().toString() );
                if ( imit.hasNext() ) {
                    buffer.append( ", " );
                }
            }
            buffer.append( "];\n" );
        }
        if ( iconAnchor != null ) {
            buffer.append( "icon.iconAnchor = " ).append( iconAnchor.getJSconstructor() ).append( ";\n" );
        }

        if ( infoWindowAnchor != null ) {
            buffer.append( "icon.infoWindowAnchor = " ).append( infoWindowAnchor.getJSconstructor() ).append( ";\n" );
        }

        if ( infoShadowAnchor != null ) {
            buffer.append( "icon.infoShadowAnchor = " ).append( infoShadowAnchor.getJSconstructor() ).append( ";\n" );
        }

        buffer.append( "return icon;\n" );
        buffer.append( "})()\n" );
        return buffer.toString();
    }

    public String getShadow() {
        return shadow;
    }

    public GSize getShadowSize() {
        return shadowSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( iconAnchor == null
            ? 0
            : iconAnchor.hashCode() );
        result = prime * result + ( iconSize == null
            ? 0
            : iconSize.hashCode() );
        result = prime * result + ( image == null
            ? 0
            : image.hashCode() );
        result = prime * result + ( imageMap == null
            ? 0
            : imageMap.hashCode() );
        result = prime * result + ( infoShadowAnchor == null
            ? 0
            : infoShadowAnchor.hashCode() );
        result = prime * result + ( infoWindowAnchor == null
            ? 0
            : infoWindowAnchor.hashCode() );
        result = prime * result + ( shadow == null
            ? 0
            : shadow.hashCode() );
        result = prime * result + ( shadowSize == null
            ? 0
            : shadowSize.hashCode() );
        return result;
    }

    public GIcon iconAnchor( final GPoint iconAnchor ) {
        final GIcon clone = clone();
        clone.iconAnchor = iconAnchor;
        return clone;
    }

    public GIcon iconSize( final GSize iconSize ) {
        final GIcon clone = clone();
        clone.iconSize = iconSize;
        return clone;
    }

    public GIcon infoShadowAnchor( final GPoint infoShadowAnchor ) {
        final GIcon clone = clone();
        clone.infoShadowAnchor = infoShadowAnchor;
        return clone;
    }

    public GIcon infoWindowAnchor( final GPoint infoWindowAnchor ) {
        final GIcon clone = clone();
        clone.infoWindowAnchor = infoWindowAnchor;
        return clone;
    }

    public void setIconAnchor( final GPoint iconAnchor ) {
        this.iconAnchor = iconAnchor;
    }

    public void setIconSize( final GSize iconSize ) {
        this.iconSize = iconSize;
    }

    public void setImage( final String image ) {
        this.image = image;
    }

    public void setImageMap( final List<Integer> imageMap ) {
        this.imageMap = imageMap;
    }

    public void setInfoShadowAnchor( final GPoint infoShadowAnchor ) {
        this.infoShadowAnchor = infoShadowAnchor;
    }

    public void setInfoWindowAnchor( final GPoint infoWindowAnchor ) {
        this.infoWindowAnchor = infoWindowAnchor;
    }

    public void setShadow( final String shadow ) {
        this.shadow = shadow;
    }

    public void setShadowSize( final GSize shadowSize ) {
        this.shadowSize = shadowSize;
    }

    public GIcon shadowSize( final GSize shadowSize ) {
        final GIcon clone = clone();
        clone.shadowSize = shadowSize;
        return clone;
    }

    public void setSchema( final String schema ) {
        final String regex = "https?";
        image.replaceFirst( regex, schema );
        if ( shadow != null ) {
            shadow.replaceFirst( regex, schema );
        }
    }

}