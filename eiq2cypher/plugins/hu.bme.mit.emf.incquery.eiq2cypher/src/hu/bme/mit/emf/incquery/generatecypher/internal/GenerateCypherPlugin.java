package hu.bme.mit.emf.incquery.generatecypher.internal;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class GenerateCypherPlugin extends AbstractUIPlugin implements
		BundleActivator {
	private static GenerateCypherPlugin INSTANCE;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	
	
	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}
	
	public static GenerateCypherPlugin getInstance() {
		return INSTANCE;
	}
}
