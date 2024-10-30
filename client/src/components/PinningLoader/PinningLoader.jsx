'use client';
import style from '@/styles/spinner.module.css';

export default function PinningLoader() {
  return (
    <div className="flex min-h-screen items-center justify-center">
      <div className={style.spinner}></div>
    </div>
  );
}
