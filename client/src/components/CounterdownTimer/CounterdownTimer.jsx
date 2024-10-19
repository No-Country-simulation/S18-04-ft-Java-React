'use client';

import { useEffect, useRef, useState } from 'react';
import { AnimatedNumber } from '../AnimatedNumber/AnimatedNumber';
import { calculateTimeLeft } from '@/lib/calcTimeLeft';
import { cn } from '@/lib/utils';
import { useConfetti } from '@/utils/hooks/useConfetti';

export const CounterdownTimer = ({ targetDate }) => {
  const [timeLeft, setTimeLeft] = useState({
    days: 0,
    hours: 0,
    minutes: 0,
    seconds: 0,
  });
  const [showConfetti, setShowConfetti] = useState(false);
  const [isBouncing, setIsBouncing] = useState(false);
  const canvasRef = useRef(null);
  const isGeneratingRef = useRef(true);

  useEffect(() => {
    const updateCountdown = () => {
      const newTimeLeft = calculateTimeLeft(targetDate);
      setTimeLeft(newTimeLeft);

      // Verifica si el temporizador ha terminado
      if (
        newTimeLeft.days === 0 &&
        newTimeLeft.hours === 0 &&
        newTimeLeft.minutes === 0 &&
        newTimeLeft.seconds === 0
      ) {
        setShowConfetti(true);
        setIsBouncing(true);
        clearInterval(intervalId);

        setTimeout(() => (isGeneratingRef.current = false), 15000);
      }
    };

    const intervalId = setInterval(updateCountdown, 1000);

    return () => clearInterval(intervalId);
  }, [targetDate]);

  useConfetti(showConfetti, canvasRef, isGeneratingRef, () => {
    setIsBouncing(false);
    setShowConfetti(false);
  });

  return (
    <>
      <div
        className={cn(
          'mt-4 grid grid-cols-4 gap-4 text-center',
          `${isBouncing ? 'animate-bounce' : ''}`
        )}>
        {Object.entries(timeLeft).map(([key, value]) => (
          <div
            key={key}
            className="flex select-none flex-col items-center transition-transform ease-in hover:scale-[1.035]">
            <AnimatedNumber value={value} />
            <div className="mt-1 text-sm uppercase">{key}</div>
          </div>
        ))}
      </div>
      {showConfetti && (
        <canvas ref={canvasRef} className="pointer-events-none fixed h-dvh w-dvw touch-none" />
      )}
    </>
  );
};
