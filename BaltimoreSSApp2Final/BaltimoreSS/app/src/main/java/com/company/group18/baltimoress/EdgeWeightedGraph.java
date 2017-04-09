package com.company.group18.baltimoress;

import java.util.ArrayList;

public class EdgeWeightedGraph {
	private int E, V, vertexID;
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	public ArrayList<Edge>[] adj;

	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = vertexID = 0;
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		adj = (ArrayList<Edge>[]) new ArrayList[this.V];
		for (int v = 0; v < V; v++){
			adj[v] = new ArrayList<Edge>();
		}
	}

	public void addVertex(Arrest a){
		if (vertexID < V){
			Vertex v = new Vertex(a,vertexID++);
			vertices.add(v);
		}else{
			System.out.println("Max Number Of Vertices added");
		}
	}

	public void addEdge(Edge e){
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		edges.add(e);
		E++;
	}

	public Vertex vertexIDtoVertex(int id){
		for (Vertex v: vertices){
			if(v.uid == id){
				return v;
			}
		}
		return null;
	}

	public Vertex arrestToVertex(Arrest a){
		for (Vertex v: vertices){
			if (v.arrest.compareTo(a) == 0){
				return v;
			}
		}
		return null;
	}


	public ArrayList<Edge> edges() {
		return edges;
	}

	public Iterable<Edge> adj(int v){
		return adj[v];
	}

	public int V(){
		return V;
	}

	public int vertexID(){
		return vertexID;
	}

	public int E(){
		return E;
	}
}