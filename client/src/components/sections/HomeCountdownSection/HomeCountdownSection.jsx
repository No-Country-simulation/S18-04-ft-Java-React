import { CounterdownTimer } from '@/components/CounterdownTimer/CounterdownTimer';

export const HomeCountdownSection = () => (
  <section className="border-gradient mx-auto mt-6 flex h-40 w-full max-w-[90%] flex-col border bg-primary-500 p-4">
    <h3 className="text-xl font-bold leading-5 text-white">Proxima simulacion en</h3>
    <CounterdownTimer targetDate="2024-10-22T20:40:30" />
  </section>
);
