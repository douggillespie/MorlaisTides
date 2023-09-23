package morlaistidedata;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import GPS.GpsData;
import PamUtils.Coordinate3d;
import PamUtils.PamUtils;
import PamView.GeneralProjector;
import PamView.GeneralProjector.ParameterType;
import PamView.GeneralProjector.ParameterUnits;
import PamView.PamKeyItem;
import PamView.PamSymbol;
import PamView.PamSymbolType;
import PamView.PanelOverlayDraw;
import PamguardMVC.PamDataUnit;

public class MorlaisTideOverlayDraw extends PanelOverlayDraw {

	protected static PamSymbol defaultSymbol = new PamSymbol(PamSymbolType.SYMBOL_CROSS, 5, 5, false, Color.RED, Color.red);
	private MorlaisTideControl tideControl;
	
	public MorlaisTideOverlayDraw(MorlaisTideControl tideControl) {
		super(defaultSymbol);
		this.tideControl = tideControl;
	}

	@Override
	public Rectangle drawDataUnit(Graphics g, PamDataUnit pamDataUnit, GeneralProjector generalProjector) {
		GpsData org = pamDataUnit.getOriginLatLong(false);
		if (org == null) {
			return null;
		}
		MorlaisTideDataUnit tideDataUnit = (MorlaisTideDataUnit) pamDataUnit;
		double t = 120;
		GpsData endGps = org.addDistanceMeters(tideDataUnit.getVx()*t, tideDataUnit.getVy()*t);
		Point2D startPt = generalProjector.getCoord3d(org).getPoint2D();
		Point2D endPt = generalProjector.getCoord3d(endGps).getPoint2D();
		PamSymbol symbol = getPamSymbol(pamDataUnit, generalProjector);
		if (symbol != null) {
			g.setColor(symbol.getLineColor());
		}
		Rectangle rect = PamSymbol.drawArrow(g, startPt.getX(), startPt.getY(), endPt.getX(), endPt.getY(), 6, 35, false);
		generalProjector.addHoverData(generalProjector.getCoord3d(endGps), pamDataUnit);
		return rect;
	}

	@Override
	public boolean canDraw(ParameterType[] parameterTypes, ParameterUnits[] parameterUnits) {
		if (parameterTypes[0] == ParameterType.LATITUDE
				&& parameterTypes[1] == ParameterType.LONGITUDE) {
			return true;
		}
		return false;
	}

	@Override
	public PamKeyItem createKeyItem(GeneralProjector generalProjector, int keyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHoverText(GeneralProjector generalProjector, PamDataUnit dataUnit, int iSide) {
		return dataUnit.getSummaryString();
	}

}
