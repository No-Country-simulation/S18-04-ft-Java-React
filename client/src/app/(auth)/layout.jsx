import Image from 'next/image';
import style from '@/styles/layout.module.css';

export default function LayoutSignup({ children }) {
  return (
    <section className={style.layoutSection}>
      <div className={style.layoutContentLogo}>
        <Image
          className={style.layoutLogo}
          src="/images/noCountryLogo.png"
          alt="No Country logo"
          width={56}
          height={46}
        />
        <Image src="/images/noCountry.png" alt="No Country" width={66} height={16} />
      </div>
      <div>{children}</div>
    </section>
  );
}
