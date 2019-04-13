/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import control.MathFx;
import control.C45;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azhary Arliansyah
 */
public class Particle implements Comparable {
    
    private List<Integer> position = new ArrayList<>();
    private List<Integer> currentBestPosition = new ArrayList<>();
    private List<Double> velocity = new ArrayList<>();
    private Double inertiaWeight;
    private Double best;
    private Double currentBest;
    private List<String> selectedFeatures = new ArrayList<>();
    private C45 clf = new C45();
    
    public Particle(int dimensions) {
        this.initializePosition(dimensions);
        this.initializeVelocity(dimensions);
        this.best = 0.0;
        this.currentBest = this.best;
        this.currentBestPosition = this.position;
        this.inertiaWeight = MathFx.randUniform(1);
    }
    
    private void initializePosition(int dimensions) {
        this.position = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            this.position.add(MathFx.randInt(1));
        }
    }
    
    private void initializeVelocity(int dimensions) {
        this.velocity = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            this.velocity.add(MathFx.randUniform(1));
        }
    }
    
    public void updatePosition() {
        int newPosition;
        for (int i = 0; i < this.position.size(); i++) {
            if (this.sigmoid(this.velocity.get(i)) > MathFx.randUniform(1)) {
                newPosition = 1;
            } else {
                newPosition = 0;
            }
            this.position.set(i, newPosition);
        }
    }
    
    public void updateVelocity(double c1, double c2
            , List<Integer> particleBestPosition) {
        for (int i = 0; i < this.velocity.size(); i++) {
            this.velocity.set(i, this.calculateVelocity(
                    this.velocity.get(i), this.position.get(i), 
                    this.currentBestPosition.get(i), 
                    particleBestPosition.get(i), c1, c2));
        }
    }
    
    public double calculateBest(List<Data> train, List<Data> test) {
        this.selectedFeatures = this.getSelectedFeatures();
        this.clf = new C45(this.selectedFeatures.toArray(new String[0]));
        this.clf.fit(train);
        this.best = this.clf.score(test);
        return this.best;
    }
    
    public List<String> getSelectedFeatures() {
        List<String> selectedAttributes = new ArrayList<>();
        for (int i = 0; i < this.position.size(); i++) {
            if (position.get(i) == 1) {
                selectedAttributes.add(Data.FEATURES[i]);
            }
        }
        return selectedAttributes;
    }
    
    public double getBest() {
        return this.best;
    }
    
    public C45 getClf() {
        return this.clf;
    }
    
    public List<Integer> getPosition() {
        return this.position;
    }
    
    private double calculateVelocity(double prevVelocity, int pos, int bestPos, 
            int bestParticlePos, double c1, double c2) {
        return this.inertiaWeight * prevVelocity + c1 * MathFx.randUniform(1) * 
                (pos - bestPos) + c2 * MathFx.randUniform(1) * 
                (pos - bestParticlePos);
    }
    
    private double sigmoid(double velocity) {
        if (velocity < 0) {
            return 1 - (1 / (1 + Math.exp(-velocity)));
        }
        return 1 / (1 + Math.exp(-velocity));
    }
    
    public double tentMap() {
        if (this.inertiaWeight < 0.7) {
            this.inertiaWeight /= 0.7;
        } else {
            this.inertiaWeight = (10 / 3) * (this.inertiaWeight * 
                    (1 - this.inertiaWeight));
        }
        return this.inertiaWeight;
    }

    @Override
    public int compareTo(Object another) {
        double anotherBest = ((Particle)another).getBest() * 100;
        return (int)(anotherBest - (this.best * 100));
    }

}
