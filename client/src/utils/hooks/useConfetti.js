import { useEffect, useLayoutEffect, useRef } from 'react';
import { Particle } from '@/lib/Particle';

export const useConfetti = (showConfetti, canvasRef, isGeneratingRef, disableCallback) => {
  const particlesRef = useRef([]);
  const animationRef = useRef();

  useLayoutEffect(() => {
    if (showConfetti && canvasRef.current) {
      const canvas = canvasRef.current;
      const ctx = canvas.getContext('2d');
      if (!ctx) return;

      canvas.width = window.innerWidth;
      canvas.height = window.innerHeight;
      canvas.style.top = '-270px';
      canvas.style.left = '-22px';

      const createParticles = () => {
        for (let i = 0; i < 100; i++) {
          particlesRef.current.push(new Particle(canvas));
        }
      };

      const animateParticles = () => {
        if (ctx) {
          ctx.clearRect(0, 0, canvas.width, canvas.height);
          particlesRef.current = particlesRef.current.filter(particle => {
            const shouldKeep = particle.update(canvas, isGeneratingRef.current);
            if (shouldKeep) particle.draw(ctx);
            return shouldKeep;
          });

          if (isGeneratingRef.current && particlesRef.current.length < 100) {
            particlesRef.current.push(new Particle(canvas));
          }

          if (particlesRef.current.length > 0) {
            animationRef.current = requestAnimationFrame(animateParticles);
          } else {
            disableCallback();
          }
        }
      };

      createParticles();
      animateParticles();

      return () => cancelAnimationFrame(animationRef.current);
    }
  }, [showConfetti, canvasRef, isGeneratingRef]);
};
