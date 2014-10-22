package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class Media extends com.fortutech.tcheckit.ejb.sessions.EntityMother  implements org.ksoap2.serialization.KvmSerializable {
    private java.lang.String description;

    private java.lang.Long id;

    private java.lang.String localPath;

    private java.lang.String mimeType;

    private java.lang.String name;

    private java.lang.String path;

    private java.lang.Integer position;

    private java.lang.String title;

    public Media() {
        super();
    }
    public Media(SoapObject so) {
        super(so);
        this.setDescription(SoapUtils.getSoapString(so, "description"));
        this.setId(SoapUtils.getSoapLong(so, "id"));
        this.setLocalPath(SoapUtils.getSoapString(so, "localPath"));        
        this.setMimeType(SoapUtils.getSoapString(so, "mimeType"));
        this.setName(SoapUtils.getSoapString(so, "name"));
        this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
        this.setPath(SoapUtils.getSoapString(so, "path"));
        this.setPosition(SoapUtils.getSoapInteger(so, "position"));
        this.setTitle(SoapUtils.getSoapString(so, "title"));
        
    }
    
    public static Media[] parse(SoapObject so, String name) {
    	ArrayList<Media> list = new ArrayList<Media>();
    	//java.util.Vector<SoapObject> so2 = (java.util.Vector<SoapObject>) SoapUtils.getSoapObjects(so, name);
    	if (so != null) {
			for (int i = 0; i < so.getPropertyCount(); i++) {
				if (so.getProperty(i) != null && so.getProperty(i).getClass().equals(SoapObject.class) ){
					PropertyInfo pi = new PropertyInfo();
					so.getPropertyInfo(i, pi);
					if (pi.getName().equals(name)) { 
				
						Media ms = new Media((SoapObject)so.getProperty (i));
					list.add(ms);
					}
				}
			}
		}
    	return list.toArray(new Media[list.size()]);
    }
    
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.String getDescription(java.lang.String description) {
        return this.description;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setLocalPath(java.lang.String localPath) {
        this.localPath = localPath;
    }

    public java.lang.String getLocalPath(java.lang.String localPath) {
        return this.localPath;
    }

    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }

    public java.lang.String getMimeType(java.lang.String mimeType) {
        return this.mimeType;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
@Override
    public java.lang.String getName() {
        return this.name;
    }

    public void setPath(java.lang.String path) {
        this.path = path;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPosition(java.lang.Integer position) {
        this.position = position;
    }

    public java.lang.Integer getPosition(java.lang.Integer position) {
        return this.position;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getTitle(java.lang.String title) {
        return this.title;
    }

    public int getPropertyCount() {
        return 8;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return description;
        case 1: return id;
        case 2: return localPath;
        case 3: return mimeType;
        case 4: return name;
        case 5: return path;
        case 6: return position;
        case 7: return title;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: description = (java.lang.String) __obj; break;
        case 1: id = (java.lang.Long) __obj; break;
        case 2: localPath = (java.lang.String) __obj; break;
        case 3: mimeType = (java.lang.String) __obj; break;
        case 4: name = (java.lang.String) __obj; break;
        case 5: path = (java.lang.String) __obj; break;
        case 6: position = (java.lang.Integer) __obj; break;
        case 7: title = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "description";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 2:
            __info.name = "localPath";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "mimeType";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "name";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "path";
            __info.type = java.lang.String.class; break;
        case 6:
            __info.name = "position";
            __info.type = java.lang.Integer.class; break;
        case 7:
            __info.name = "title";
            __info.type = java.lang.String.class; break;
        }
    }

}
