package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.xml.bind.JAXBException;

import map.MapGraph;
import map.MapPoint;
import xmlhandle.JAXBMarshalling;

public class GraphOverlayFactory {
	public BufferedImage localBufferedMapImage;
	public static MapGraph mapGraph;
	public static String loadPath = "resources/GoTGraph.xml";

	public static void drawGraphOverImage(BufferedImage localBufferedMapImage) {
		Graphics graphics = localBufferedMapImage.getGraphics();

		try {
			mapGraph = JAXBMarshalling.loadMapGraph(loadPath);
			for (MapPoint point : mapGraph.getNodes()) {
				graphics.fillOval(point.getxCoord() - 5, point.getyCoord() - 5, 15, 15);
				graphics.setColor(Color.YELLOW);
				graphics.drawString(point.getName(), point.getxCoord() + 10, point.getyCoord());

				for (MapPoint point2 : point.getNeighbors()) {
					System.out.println(
							"\n Drawing node : " + point.getName() + "\n connected to : " + point2.getName() + point2);
					System.out.println("--------------------------------------------------------");
					graphics.drawLine(point.getxCoord(), point.getyCoord(), point2.getxCoord(), point2.getyCoord());
					graphics.drawString(point2.getName(), point2.getxCoord() + 10, point2.getyCoord());

				}

			}

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.dispose();
	}

	public static void drawGraphRouteImage(BufferedImage localBufferedMapImage) {
		Graphics graphics = localBufferedMapImage.getGraphics();
		List<MapPoint> route = MainMenuController.route;

		try {
			mapGraph = JAXBMarshalling.loadMapGraph(loadPath);

			for (int i = 0; i < route.size(); i++) {
				MapPoint point = route.get(i);

				graphics.fillOval(point.getxCoord() - 5, point.getyCoord() - 5, 15, 15);
				graphics.setColor(Color.RED);
				graphics.drawString(point.getName(), point.getxCoord() + 10, point.getyCoord());
				if (i > 0) {
					MapPoint point2 = route.get(i - 1);
					System.out.println(
							"\n Drawing node : " + point.getName() + "\n connected to : " + point2.getName() + point2);
					System.out.println("--------------------------------------------------------");
					graphics.drawLine(point.getxCoord(), point.getyCoord(), point2.getxCoord(), point2.getyCoord());
					graphics.drawString(point2.getName(), point2.getxCoord() + 10, point2.getyCoord());

				}
			}

		} catch (

		JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.dispose();
	}

}