import Image from 'next/image';
import google from '/public/images/iconGoogle.png';
import facebook from '/public/images/iconFace.png';
import apple from '/public/images/iconMac.png';

export const SocialButtons = () => {
  return (
    <div className="gap- mx-auto flex items-center justify-center gap-4 pb-16 pt-4">
      <Image width={30} height={30} src={google} alt="Google" />
      <Image width={30} height={30} src={facebook} alt="Facebook" />
      <Image width={30} height={30} src={apple} alt="Apple" />
    </div>
  );
};
