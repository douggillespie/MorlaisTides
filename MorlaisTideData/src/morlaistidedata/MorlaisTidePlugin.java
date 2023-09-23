package morlaistidedata;

import PamModel.PamDependency;
import PamModel.PamPluginInterface;

public class MorlaisTidePlugin implements PamPluginInterface {

	private String jarFile;
	
	@Override
	public String getDefaultName() {
		return MorlaisTideControl.unitType;
	}

	@Override
	public String getHelpSetName() {
		return null;
	}

	@Override
	public void setJarFile(String jarFile) {
		this.jarFile = jarFile;
	}

	@Override
	public String getJarFile() {
		return jarFile;
	}

	@Override
	public String getDeveloperName() {
		return "Doug G";
	}

	@Override
	public String getContactEmail() {
		return "";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getPamVerDevelopedOn() {
		return "V2.02.09";
	}

	@Override
	public String getPamVerTestedOn() {
		return "V2.02.09";
	}

	@Override
	public String getAboutText() {
		return "Display Morlais tides";
	}

	@Override
	public String getClassName() {
		return MorlaisTideControl.class.getName();
	}

	@Override
	public String getDescription() {
		return "Morlais tides";
	}

	@Override
	public String getMenuGroup() {
		return "Utilities";
	}

	@Override
	public String getToolTip() {
		return null;
	}

	@Override
	public PamDependency getDependency() {
		return null;
	}

	@Override
	public int getMinNumber() {
		return 0;
	}

	@Override
	public int getMaxNumber() {
		return 1;
	}

	@Override
	public int getNInstances() {
		return 0;
	}

	@Override
	public boolean isItHidden() {
		return false;
	}

	@Override
	public int allowedModes() {
		return PamPluginInterface.VIEWERONLY;
	}

}
