import Image from 'next/image';
import Logo from '/public/images/svg/NoCountry.svg';
import Link from 'next/link';
export const AuthFooter = () => {
  return (
    <footer className="w-fullitems-center mt-auto flex justify-center pb-5">
      <Link href="/" className="w-fit">
        <Image width={108} height={19} src={Logo} alt="logo" />
      </Link>
    </footer>
  );
};
