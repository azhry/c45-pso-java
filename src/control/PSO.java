/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Data;
import entity.Particle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Azhary Arliansyah
 */
public class PSO {
    
    private int particleSize;
    private int populationSize;
    private int numIteration;
    private double c1;
    private double c2;
    private double target;
    
    private List<Particle> particles = new ArrayList<>();
    private List<Particle> iterationBest = new ArrayList<>();
    
    public PSO(int particleSize, int populationSize, int numIteration, 
            double c1, double c2, double target) {
        this.particleSize = particleSize;
        this.populationSize = populationSize;
        this.numIteration = numIteration;
        this.c1 = c1;
        this.c2 = c2;
        this.target = target;
        
        for (int i = 0; i < populationSize; i++) {
            this.particles.add(new Particle(particleSize));
        }
    }
    
    public Particle exec(List<Data> train, List<Data> test) {
        for (int i = 0; i < this.numIteration; i++) {
//            System.out.println("ITERATION: " + (i + 1));
            for (int j = 0; j < this.populationSize; j++) {
                this.particles.get(j).calculateBest(train, test);
                this.particles.get(j).tentMap();
//                System.out.println("\tPARTICLE " + (j + 1) + ": " + 
//                        this.particles.get(j).getBest());
            }
            Collections.sort(this.particles);
            this.iterationBest.add(this.particles.get(0));
            
//            System.out.println("\tBEST PARTICLE: " + 
//                    this.particles.get(0).getBest());
            
            if (this.particles.get(0).getBest() > this.target) {
                return this.particles.get(0);
            }
            for (int j = 0; j < this.populationSize; j++) {
                this.particles.get(j).updateVelocity(this.c1, this.c2, 
                        this.particles.get(0).getPosition());
                this.particles.get(j).updatePosition();
            }
        }
        Collections.sort(this.iterationBest);
        return this.iterationBest.get(0);
    }
}
