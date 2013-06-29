package hu.bme.mit.incquery.vedl.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class EdlHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String EDL_ENUM_ID = "edlEnum";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(EDL_ENUM_ID, "Edl enums", edlEnumTextStyle());
	}

	@Override
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(254, 61, 27));
		return textStyle;
	}

	@Override
	public TextStyle stringTextStyle() {
		TextStyle stringTextStyle = super.stringTextStyle();
		stringTextStyle.setStyle(SWT.ITALIC);
		return stringTextStyle;
	}

	public TextStyle edlEnumTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 0, 255));
		return textStyle;
	}
}
