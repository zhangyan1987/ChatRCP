package org.eclipsercp.hyperbola;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipsercp.hyperbola.views.ContactView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView(ContactView.ID, IPageLayout.LEFT, 1, layout.getEditorArea());
		//layout.addStandaloneView(ContactView.ID, false,IPageLayout.LEFT, 1, layout.getEditorArea());
	}
}
