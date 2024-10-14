import Image from 'next/image';
import style from '@/styles/layoutSignup.module.css';

export default function LayoutSignup({ children }) {
  return (
    <div className={style.layoutSection}>
      <header className={style.layoutContentLogo}>
        <Image
          className={style.layoutLogo}
          src="/images/noCountryLogo.png"
          alt="No Country logo"
          width={56}
          height={46}
        />
        <Image src="/images/noCountry.png" alt="No Country" width={66} height={16} />
      </header>
      <main className="flex size-full items-center justify-center">{children}</main>
    </div>
  );
}
