import { AnimatePresence, motion } from 'framer-motion';

export const AnimatedNumber = ({ value }) => (
  <div className="relative size-16 overflow-hidden">
    <AnimatePresence mode="popLayout">
      <motion.div
        key={value}
        initial={{ y: 50, opacity: 0 }}
        animate={{ y: 0, opacity: 1 }}
        exit={{ y: -50, opacity: 0 }}
        transition={{ duration: 0.3, ease: 'easeInOut' }}
        className="absolute inset-0 flex items-center justify-center">
        <span className="text-4xl font-bold">{value.toString().padStart(2, '0')}</span>
      </motion.div>
    </AnimatePresence>
  </div>
);
