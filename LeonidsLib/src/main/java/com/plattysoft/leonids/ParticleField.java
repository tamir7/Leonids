package com.plattysoft.leonids;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

class ParticleField extends View {
    private final Object lock = new Object();
	private List<Particle> mParticles;

	public ParticleField(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public ParticleField(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ParticleField(Context context) {
		super(context);
	}

	public void setParticles(List<Particle> particles) {
        synchronized (lock) {
            mParticles = new ArrayList<>(particles);
        }
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// Draw all the particles
        synchronized (lock) {
            for (Particle particle : mParticles) {
                particle.draw(canvas);
            }
        }
	}
}
