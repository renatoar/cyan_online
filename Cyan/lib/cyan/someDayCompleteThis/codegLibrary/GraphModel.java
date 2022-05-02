package meta.codegLibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class GraphModel {
	public static final char INF = '\u221e'; //'∞'; // Char to indicate that a value is infinity

	private File file;
	private BufferedReader in;
	private BufferedWriter out;

	private ArrayList<GraphModelVertice> vertices; // Vertices List
	private ArrayList<GraphModelEdge> edges; // Edges List
	private Boolean directed;

	public GraphModel() {
		vertices = new ArrayList<GraphModelVertice>();
		edges = new ArrayList<GraphModelEdge>();
		directed = false;
	}

	public GraphModel(String filename) {
		this();

		file = new File(filename);
		if (filename != "")
			initFromFile();
	}

	private void initFromFile() {
		try {
			this.in = new BufferedReader(new FileReader(file));

			String line;
			Boolean vertice = false;

			StringTokenizer tokenizer = null;
			while (in.ready()) {
				line = in.readLine();
				vertice = line.substring(0, 1).equals("v");
				line = line.replace("v", "");
				tokenizer = new StringTokenizer(line, " ");

				if (vertice) {
					int v, x, y;
					if (tokenizer.countTokens() == 3) {
						v = Integer.parseInt(tokenizer.nextToken());
						x = Integer.parseInt(tokenizer.nextToken());
						y = Integer.parseInt(tokenizer.nextToken());
						vertices.add(new GraphModelVertice(x, y, v));
					}
				} else {
					int v1, v2;
					double c;

					if (tokenizer.countTokens() == 3) {
						v1 = Integer.parseInt(tokenizer.nextToken());
						v2 = Integer.parseInt(tokenizer.nextToken());
						c  = Double.parseDouble(tokenizer.nextToken());

						GraphModelVertice vt1 = getVertice(v1);
						GraphModelVertice vt2 = getVertice(v2);

						if (vt1 != null && vt2 != null && !hasEdge(vt1, vt2)) {
							GraphModelEdge edge = new GraphModelEdge(getVertice(v1), getVertice(v2), c);
							edges.add(edge);

							vt1.addOrigin(edge);
							vt2.addDestiny(edge);
						}
					}
				}
			}

		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error: File not found.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: Invalid data.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Invalid File.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		}
	}

	public void setFile(String filename) {
		file = new File(filename);
	}

	public void saveToFile() {

		try {
			this.out = new BufferedWriter(new PrintWriter(new FileWriter(file)));

			String line;
			for (GraphModelVertice vertice : this.getVertices()) {
				int v = vertice.getLabel();
				int x = vertice.getX();
				int y = vertice.getY();
				line = "v" + v + " " + x + " " + y;
				out.write(line);
				out.newLine();
			}

			for (GraphModelVertice vertice : this.getVertices()) {
				for (GraphModelEdge aresta : vertice.getEdges()) {
					if (aresta.getOrigin().getLabel() == vertice.getLabel()) {
						int origin = aresta.getOrigin().getLabel();
						int destiny = aresta.getDestiny().getLabel();
						double cost = aresta.getCost();

						line = origin + " " + destiny + " " + cost;
						out.write(line);
						out.newLine();
					}
				}
			}
			out.flush();
			out.close();

		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error: File not found.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: Invalid data.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Invalid File.\n", "Error", JOptionPane.ERROR_MESSAGE);
			System.err.println(ex.getMessage());
		}
	}

	public StringBuffer getGraphData() {

		String data = "";

		data = "[. directed = " + this.directed + ",\n";

		data += "vertices = [";
		int size = this.getVertices().size();
		for (GraphModelVertice vertice : this.getVertices()) {
			int v = vertice.getLabel();
			data += " \"" + v + "\"";
			if (--size > 0) {
				data += ",";
			}
		}
		//data = data.substring(0, data.length()-2);
		data += " ],\n";

		data += "edges = [ ";

		int n = 0;
		for (GraphModelVertice vertice : this.getVertices()) {
			for (GraphModelEdge aresta : vertice.getEdges()) {
				if (aresta.getOrigin().getLabel() == vertice.getLabel()) {
					int origin = aresta.getOrigin().getLabel();
					int destiny = aresta.getDestiny().getLabel();
					double cost = aresta.getCost();
					n++;
					data += "[. \"" + origin + "\", \"" + destiny + "\", \"" + cost + "\" .], \n";
				}
			}
		}
		if (n>0) {
			data = data.substring(0, data.length()-3);
		}
		data += " ]\n";

		data += ".]";

		return new StringBuffer(data);
	}

	public ArrayList<GraphModelVertice> getVertices() {
		return vertices;
	}
	public ArrayList<GraphModelEdge> getEdges() {
		return edges;
	}

	public int getNumEdges() {
		return edges.size();
	}

	public int getNumVertices() {
		return vertices.size();
	}

	public int addVertice(int x, int y, int label) {
		if (label >= 0) {
			if (!this.hasVertice(label)) {
				vertices.add(new GraphModelVertice(x, y, label));
				return 0;
			}else {
				return 1;
			}
		} else
			return 2;
	}

	public int removeVertice(int label) {
		if (label >= 0) {
			if (this.hasVertice(label)) {

				GraphModelVertice vertice = getVertice(label);

				if (vertice != null) {

					GraphModelEdge edge = null;
					for (int i = 0; i < edges.size(); ++i) {
						edge = edges.get(i);
						if (edge.getOrigin().equals(vertice)) {
							removeEdge(vertice, edge.getDestiny());
							--i;
						} else if (edge.getDestiny().equals(vertice)) {
							removeEdge(edge.getOrigin(), vertice);
							--i;
						}
					}
					vertices.remove(vertice);
					return 0;
				}
			}
			return 1;
		} else
			return 2;
	}

	public boolean hasVertice(int label) {
		Iterator<GraphModelVertice> it = vertices.iterator();
		GraphModelVertice vertice = null;

		while (it.hasNext()) {
			vertice = it.next();

			if (vertice.getLabel() == label)
				return true;
		}
		return false;
	}

	public int addEdge(GraphModelVertice origin, GraphModelVertice destiny, double cost) {
		if (!this.hasEdge(origin, destiny)) {
			GraphModelEdge edge = new GraphModelEdge(origin, destiny, cost);
			edges.add(edge);

			origin.addOrigin(edge);
			destiny.addDestiny(edge);

			return 0;
		} else {
			return 2;
		}
	}

	public boolean removeEdge(GraphModelVertice origin, GraphModelVertice destiny) {
		if (this.hasEdge(origin, destiny)) {

			int indexOfEdge = getIndexOfEdge(origin, destiny);
			GraphModelEdge edge = edges.get(indexOfEdge);

			origin.removeOrigin(edge);
			destiny.removeDestiny(edge);

			edges.remove(indexOfEdge);

			return true;
		} else {
			return false;
		}
	}

	private int getIndexOfEdge(GraphModelVertice origin, GraphModelVertice destiny) {
		int i = 0;
		Iterator<GraphModelEdge> it = edges.iterator();

		while (it.hasNext()) {
			GraphModelEdge edge = it.next();

			if (edge.getOrigin().getLabel() == origin.getLabel() && edge.getDestiny().getLabel() == destiny.getLabel())
				return i;
			++i;
		}
		return -1;
	}

	public GraphModelVertice getVertice(int label) {
		Iterator<GraphModelVertice> it = vertices.iterator();

		while (it.hasNext()) {
			GraphModelVertice v = it.next();
			if (v.getLabel() == label)
				return v;
		}
		return null;
	}

	public boolean hasEdge(GraphModelVertice origin, GraphModelVertice destiny) {
		Iterator<GraphModelEdge> it = edges.iterator();

		while (it.hasNext()) {
			GraphModelEdge edge = it.next();

			if (edge.getOrigin().equals(origin) &&
					edge.getDestiny().equals(destiny) &&
					edge.getCost() != -1) {
				return true;
			}
		}
		return false;
	}

	public GraphModelEdge getEdge(GraphModelVertice origin, GraphModelVertice destiny) {
		Iterator<GraphModelEdge> it = edges.iterator();

		while (it.hasNext()) {
			GraphModelEdge edge = it.next();

			if (edge.getOrigin().equals(origin) &&
					edge.getDestiny().equals(destiny) &&
					edge.getCost() != -1) {
				return edge;
			}
		}
		return null;
	}

	public double getEdgeCost(GraphModelVertice origin, GraphModelVertice destiny) {
		if (this.hasEdge(origin, destiny)) {
			return edges.get(getIndexOfEdge(origin, destiny)).getCost();
		} else {
			return -1;
		}
	}

	public GraphModelVertice getVerticeByXY(int x, int y) {
		Iterator<GraphModelVertice> it = vertices.iterator();
		GraphModelVertice vertice = null;
		while (it.hasNext()) {
			vertice = it.next();

			if (vertice.isOnVertice(x, y))
				return vertice;
		}
		return null;
	}

	public Boolean isDirected() {
		return directed;
	}

	public void setDirected(Boolean directed) {
		this.directed = directed;
	}

}