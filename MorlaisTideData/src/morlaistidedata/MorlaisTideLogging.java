package morlaistidedata;

import java.sql.Types;

import PamguardMVC.PamDataUnit;
import generalDatabase.PamTableDefinition;
import generalDatabase.PamTableItem;
import generalDatabase.SQLLogging;
import generalDatabase.SQLTypes;

public class MorlaisTideLogging extends SQLLogging {
	
	private PamTableItem vx, vy, free_surface, depth;

	protected MorlaisTideLogging(MorlaisTideDataBlock pamDataBlock) {
		super(pamDataBlock);
		PamTableDefinition tableDef = new PamTableDefinition("Morlais Tides");
		tableDef.addTableItem(vx = new PamTableItem("vx", Types.DOUBLE));
		tableDef.addTableItem(vy = new PamTableItem("vy", Types.DOUBLE));
		tableDef.addTableItem(free_surface = new PamTableItem("free_surface", Types.DOUBLE));
		tableDef.addTableItem(depth = new PamTableItem("depth", Types.DOUBLE));
		setTableDefinition(tableDef);
	}

	@Override
	public void setTableData(SQLTypes sqlTypes, PamDataUnit pamDataUnit) {
		// TODO Auto-generated method stub

	}

	@Override
	protected PamDataUnit createDataUnit(SQLTypes sqlTypes, long timeMilliseconds, int databaseIndex) {
		double x = vx.getDoubleValue();
		double y = vy.getDoubleValue();
		double fs = free_surface.getDoubleValue();
		double d = depth.getDoubleValue();
		return new MorlaisTideDataUnit(timeMilliseconds, x, y, fs, d);
	}

}
