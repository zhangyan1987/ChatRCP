package org.eclipsercp.hyperbola.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipsercp.hyperbola.Application;

public class ImageUtil {

	private static Map<Object, Image> registry = new HashMap<Object, Image>();

	public static Image getImage(String id, Object source) {

		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(Application.PLUGIN_ID, id);
		Image image = imageDescriptor.createImage();
		registry.put(source, image);
		return image;

	}

	public static void dispose(Object source) {

		if (registry.get(source) != null) {
			registry.get(source).dispose();
			registry.remove(source);
		}
	}

}
